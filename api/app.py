#!/usr/bin/python3
""" Entry point to the api """

from flask import Flask
from .routes.user_routes import user_bp
from .routes.activity_routes import activity_bp

app = Flask(__name__)

app.register_blueprint(user_bp)
app.register_blueprint(activity_bp)

if __name__ == "__main__":
    app.run(debug=True)
