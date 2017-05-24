from django.db import models


class Evento(models.Model):
    id = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=100)
    imagen = models.ImageField(blank=True)
    ubicacion = models.GenericIPAddressField()
    fecha = models.DateField()
    invitados = models.ManyToManyField(Invitado)


class Invitado(models.Model):
    nombre = models.CharField(max_length=100)
    imagen = models.ImageField(blank=True)



