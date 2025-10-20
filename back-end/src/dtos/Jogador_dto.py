from pydantic import BaseModel
from typing import Optional

class Jogador_create(BaseModel):
    nome_completo: str
    nome_usuario: str
    email: str
    senha_criptografada: str

class jogador_response(BaseModel):
    id: int
    nome_usuario: str
    pontuacao_maxima: int