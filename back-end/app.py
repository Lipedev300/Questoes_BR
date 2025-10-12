from fastapi import FastAPI

server = FastAPI()
@server.get("/status")
def status():
    return {"Status server": "Ok", "App": "online"}