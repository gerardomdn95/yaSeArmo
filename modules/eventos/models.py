from django.db import models


class Invitado(models.Model):
    nombre = models.CharField(max_length=100)
    imagen = models.URLField(blank=True, null=True)


class Evento(models.Model):
    id = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=100)
    imagen = models.URLField(blank=True, null=True)
    ubicacion = models.TextField()
    fecha = models.DateField()
    invitados = models.ManyToManyField(Invitado)




