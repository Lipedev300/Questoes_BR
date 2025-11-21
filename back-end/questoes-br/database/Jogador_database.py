from sqlmodel import SQLModel, Field, Relationship
from entity.Jogador import Jogador
from entity.Partida import Partida
from typing import Optional, List

class Jogador_database(Jogador, table=True):
    __tablename__ = "jogador"
    id: Optional[int] = Field(default=None, primary_key=True)
    apelido: str = Field(unique=True, max_length=30)
    pontuacao_maxima: int = Field(default=0)
    partidas: List["Partida"] = Relationship(back_populates="jogador")