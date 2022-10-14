from mongoengine import DynamicDocument
from mongoengine import IntField, StringField, DecimalField, BooleanField
from core.settings import settings


class Employee(DynamicDocument):

    
    name = StringField()
    email = StringField()

    meta = {'db_alias': settings.DB_ALIAS, 'collection': "employee"}