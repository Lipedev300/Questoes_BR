from entity.Partida_pergunta import partida_pergunta
from entity.Partida import Partida
from entity.pergunta import pergunta
from database.Partida_database import Partida_database
from database.Pergunta_database import Pergunta_database
from sqlmodel import SQLModel, Field, Relationship
from typing import Optional

class Partida_perguntaDatabase(partida_pergunta, table=True):
    __tablename__ = "partida_pergunta"
    id: Optional[int] = Field(default=None, primary_key=True)
    partida_id: int = Field(foreign_key="partida.id_partida")
    pergunta_id: int = Field(foreign_key="pergunta.id")
    partida: Partida_database = Relationship(back_populates="pergunta_links")
    pergunta: "Pergunta_database" = Relationship(back_populates="partida_links")
    status_partida: Optional[str] = Field(default=None, max_length=20)
    resposta_jogador: Optional[str] = Field(default=None, max_length=10)
    acertou: Optional[bool] = Field(default=False)