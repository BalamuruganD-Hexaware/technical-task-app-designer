from business.utils import convert_model_to_dict
from schema import employee as SchemaEmployee
from db.models.employee import Employee
from db.repo import employeerepo


def fetch_employee():
    rows = employeerepo.get_employee()
    return [convert_model_to_dict(row) for row in rows]

def insert_employee(schema_employee):
    schema_employee_dict = {key: value for key, value in schema_employee.dict().items() if key != 'id'}
    employee = Employee(**schema_employee_dict)
    employeerepo.insert_employee(employee)

def update_employee(id, schema_employee):
    employee = schema_employee.dict()
    del employee['id']
    employeerepo.update_employee(id, employee)

def delete_employee(id):
    employeerepo.delete_employee(id)