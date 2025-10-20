from pydantic import BaseModel

class Feedback_create(BaseModel):
    nome_usuario: str
    nome_completo: str
    assunto: str
    mensagem: str

class Feedback_response(BaseModel):
    nome_usuario: str
    id_jogador: int
    id_mensagem: int
    assunto: str
    mensagem: str