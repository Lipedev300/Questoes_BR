from pydantic import BaseModel
from typing import Optional
from .Jogador import Jogador

class Partida(BaseModel):
    id_partida: Optional[int] = None
    jogador: Jogador
    pontuacao: int = 0
    vidas: int = 0