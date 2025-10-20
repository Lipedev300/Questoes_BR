from pydantic import BaseModel
from typing import Optional

class Jogador(BaseModel):
    id: Optional[int] = None
    nome_completo: str
    nome_usuario: str
    email: str
    senha_hash: str
    pontuacaoMaxima: int