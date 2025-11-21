from sqlmodel import SQLModel, Field, Relationship, Column, JSON
from entity.Jogador import Jogador
from entity.Partida import Partida
from entity.pergunta import pergunta
from entity.Partida_pergunta import partida_pergunta
from typing import Optional, List, Dict, Any

class Jogador_database(Jogador, table=True):
    __tablename__ = "jogador"
    id: Optional[int] = Field(default=None, primary_key=True)
    apelido: str = Field(unique=True, max_length=30)
    pontuacao_maxima: int = Field(default=0)
    partidas: List[Partida] = Relationship(back_populates="jogador")

class Pergunta_database(pergunta, table=True):
    __tablename__ = "pergunta"
    id: Optional[int] = Field(default=None, primary_key=True)
    categoria_pergunta: str = Field(max_length=50)
    texto_pergunta: str
    alternativas: dict[str, Any] = Field(sa_column=Column(JSON), default={})
    resposta_correta: str = Field(max_length=10)
    partida_links: List["Partida_perguntaDatabase"] = Relationship(back_populates="pergunta")

class Partida_database(Partida, table=True):
    __tablename__ = "partida"
    id_partida: Optional[int] = Field(default=None, primary_key=True)
    id_jogador: int = Field(foreign_key="jogador.id")
    jogador: Jogador = Relationship(back_populates="partidas")
    pontuacao: int = Field(default=0)
    vidas: int = Field(default=3)
    pergunta_links: List["Partida_perguntaDatabase"] = Relationship(back_populates="partida")

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