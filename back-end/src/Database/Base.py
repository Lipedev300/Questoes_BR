#classe base para as entidades conversarem com o ORM

from typing import Any
from sqlalchemy.orm import DeclarativeBase, MappedAsDataclass

class Base(MappedAsDataclass, DeclarativeBase):
    type_annotation_map: dict[type[Any], Any] = {}
    __abstract__ = True