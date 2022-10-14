from typing import Optional
from pydantic import BaseModel


class Employee(BaseModel):
    id: Optional[str]

    name: str
    email: str
