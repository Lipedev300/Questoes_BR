from pydantic import BaseModel
from typing import Optional
from .Jogador import Jogador

class Partida(BaseModel):
    id_partida: Optional[int] = None
    id_jogador: int
    jogador: Jogador
    pontuacao: int = 0
    vidas: int = 0