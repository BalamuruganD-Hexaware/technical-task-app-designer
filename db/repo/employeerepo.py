from db.models.employee import Employee
from db.connection import get_db
db = get_db()

def get_employee():
    employee = Employee.objects
    return employee


def insert_employee(employee):
    employee.save()


def update_employee(id, schema_employee):
    employee = Employee.objects(id=id)[0]
    employee.update(**schema_employee)


def delete_employee(id):
    employee = Employee.objects(id=id)[0]
    employee.delete()
