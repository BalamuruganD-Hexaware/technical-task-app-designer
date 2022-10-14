import json
import unittest
from unittest import mock
from fastapi.testclient import TestClient
from api.routes import app
from schema.employee import Employee
from core.logger import logger

ENDPOINT = '/employee'
SUCCESS_MSG = '"success"'


class TestEmployeeAPI(unittest.TestCase):

    def setUp(self) -> None:
        self.employee = {
            '_id': {'$oid': 'dscvf'},
            'name': '2Fs3d',
            'email': 'ipZ2d'
        }
        self.employee_list = [self.employee]
        self.client = TestClient(app)
        logger.disabled = True

    @mock.patch('api.employeeapi.employeeservice.fetch_employee')
    def test_api_fetch_employee(self, mock_fetch):

        mock_fetch.return_value = self.employee_list

        response = self.client.get(ENDPOINT)
        response_content = json.loads(response.content.decode('utf-8'))

        assert response.status_code == 200
        assert response_content == self.employee_list

    @mock.patch('api.employeeapi.employeeservice.insert_employee')
    def test_api_insert_employee(self, mock_insert):

        mock_insert.return_value = self.employee_list

        response = self.client.post(ENDPOINT, data = json.dumps(self.employee))
        response_content = response.content.decode('utf-8')

        assert response_content == SUCCESS_MSG
        assert mock_insert.called

    @mock.patch('api.employeeapi.employeeservice.update_employee')
    def test_api_update_employee(self, mock_update):

        mock_update.return_value = self.employee_list

        response = self.client.put(f'{ENDPOINT}/dfghv', data = json.dumps(self.employee))
        response_content = response.content.decode('utf-8')

        assert response_content == SUCCESS_MSG
        assert mock_update.called

    @mock.patch('api.employeeapi.employeeservice.delete_employee')
    def test_api_delete_employee(self, mock_delete):

        mock_delete.return_value = self.employee_list

        response = self.client.delete(f'{ENDPOINT}/dfghv')
        response_content = response.content.decode('utf-8')

        assert response.status_code == 200
        assert response_content == SUCCESS_MSG
        assert mock_delete.called
