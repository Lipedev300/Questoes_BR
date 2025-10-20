from pydantic import BaseModel
from typing import Optional
from Pergunta_dto import pergunta_response

class Partida_create(BaseModel):
    quantidade_perguntas: int

class Partida_response(BaseModel):
    id_partida: int
    id_jogador: int
    primeira_pergunta: pergunta_response
    pontuacao: int
    vidas: int