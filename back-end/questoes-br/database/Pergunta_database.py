from entity.pergunta import pergunta
from database.Partida_perguntaDatabase import Partida_perguntaDatabase
from typing import Optional, Dict, Any, List
from sqlmodel import SQLModel, Field, Relationship, Column, JSON

class Pergunta_database(pergunta, table=True):
    __tablename__ = "pergunta"
    id: Optional[int] = Field(default=None, primary_key=True)
    categoria_pergunta: str = Field(max_length=50)
    texto_pergunta: str
    alternativas: dict[str, Any] = Field(sa_column=Column(JSON), default={})
    resposta_correta: str = Field(max_length=10)
    partida_links: List[Partida_perguntaDatabase] = Relationship(back_populates="pergunta")