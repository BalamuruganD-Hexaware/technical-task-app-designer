import unittest
from unittest import mock
from schema.employee import Employee as EmployeeSchema
from db.models.employee import Employee
from api.routes import app
from business import employeeservice
import json

ENDPOINT = '/employee'
SUCCESS_MSG = '"success"'


class TestEmployeeService(unittest.TestCase):

    def setUp(self) -> None:
        self.employee = {
            '_id': {'$oid': 'dscvf'},
            'name': '0zGU5',
            'email': 'DdOpF'
        }
        self.employee_altered = json.loads(json.dumps(self.employee))
        del self.employee_altered['_id']
        self.employee_schema_obj = EmployeeSchema(**self.employee)
        self.employee_model_obj = Employee(**self.employee)
        self.employee_model_obj_list = [Employee(**self.employee)]
    
    @mock.patch('business.employeeservice.employeerepo.get_employee')
    def test_fetch_employee(self, mock_fetch):

        mock_fetch.return_value = self.employee_model_obj_list

        out = employeeservice.fetch_employee()
        
        assert out == [self.employee_altered]
        assert mock_fetch.called

    @mock.patch('business.employeeservice.employeerepo.insert_employee')
    def test_insert_employee(self, mock_insert):

        mock_insert.return_value = None

        out = employeeservice.insert_employee(self.employee_schema_obj)
        
        assert mock_insert.called
        assert out == None


    @mock.patch('business.employeeservice.employeerepo.update_employee')
    def test_update_employee(self, mock_update):

        mock_update.return_value = None

        out = employeeservice.update_employee('dfghv', self.employee_schema_obj)
        
        assert mock_update.called
        assert out == None

    @mock.patch('business.employeeservice.employeerepo.delete_employee')
    def test_delete_employee(self, mock_delete):

        mock_delete.return_value = None

        out = employeeservice.delete_employee('dfghv')
        
        assert mock_delete.called
        assert out == None
