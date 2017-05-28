from django.db import models
from django.contrib.auth.models import User
from django.contrib.postgres.fields import ArrayField


class Invitado(models.Model):
    user = models.OneToOneField(User)  # Nombre viene incluido en el modelo de user
    imagen = models.URLField(blank=True, null=True)

    def __str__(self):
        return "%s %s" % (str(self.user.first_name), str(self.user.last_name))


class Encuesta(models.Model):
    id = models.AutoField(primary_key=True)
    opciones = ArrayField(
        models.CharField(max_length=100)
    )
    tiempo_fin = models.DateTimeField(blank=True, null=True)  # DUDA

    def __str__(self):
        return "Encuesta N° %s" % (str(self.id))


class Evento(models.Model):
    id = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=100)
    imagen = models.URLField(blank=True, null=True)
    ubicacion = models.TextField()
    fecha = models.DateField()
    invitados = models.ManyToManyField(Invitado)
    encuesta = models.OneToOneField(Encuesta)

    def __str__(self):
        return "Evento '%s'" % (str(self.nombre))
