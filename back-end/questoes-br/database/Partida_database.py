from entity.Partida import Partida
from entity.Jogador import Jogador
from database.Partida_perguntaDatabase import Partida_perguntaDatabase
from sqlmodel import SQLModel, Field, Relationship
from typing import Optional, List

class Partida_database(Partida, table=True):
    __tablename__ = "partida"
    id_partida: Optional[int] = Field(default=None, primary_key=True)
    id_jogador: int = Field(foreign_key="jogador.id")
    jogador: Jogador = Relationship(back_populates="partidas")
    pontuacao: int = Field(default=0)
    vidas: int = Field(default=3)
    pergunta_links: List[Partida_perguntaDatabase] = Relationship(back_populates="partida")