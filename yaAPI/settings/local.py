from .base import *
import os

SECRET_KEY = 'by^w^91m5+z^3-7yk@z$4ebc%!-=0l%4ecqv(f6+w(q$*f1a32'

DEBUG = True

ALLOWED_HOSTS = []

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.postgresql_psycopg2',
        'NAME': 'ya_db',
        'USER': 'ya_admin',
        'PASSWORD': 'JorochoS',
        'HOST': 'localhost',
        'PORT': '5432'
    }
}