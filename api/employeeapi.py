import traceback
from fastapi import APIRouter, HTTPException
from business import employeeservice
from schema.employee import Employee

router = APIRouter(prefix="/employee")


@router.get('')
def api_fetch_employee():
    return employeeservice.fetch_employee()

@router.post('')
def api_insert_employee(employee: Employee):
    employeeservice.insert_employee(employee)
    return "success"

@router.put('/{id}')
def api_update_employee(id: str, employee: Employee):
    employeeservice.update_employee(id, employee)
    return "success"

@router.delete('/{id}')
def api_delete_employee(id: str):
    employeeservice.delete_employee(id)
    return "success"