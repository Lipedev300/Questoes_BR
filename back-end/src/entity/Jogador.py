from pydantic import BaseModel
from typing import Optional

class Jogador(BaseModel):
    id: Optional[int] = None
    nome_usuario: str
    senha_hash: str
    pontuacaoMaxima: int