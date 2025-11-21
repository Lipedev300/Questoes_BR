from pydantic import BaseModel
from typing import Optional
from Partida import Partida

class Jogador(BaseModel):
    id: Optional[int] = None
    apelido: str
    pontuacao_maxima: int = 0
    partidas: list["Partida"] = []