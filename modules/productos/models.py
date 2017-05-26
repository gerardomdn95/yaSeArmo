from django.db import models


class Productos(models.Model):

    CATEGORIAS = (
        ('AL', 'Alcohol'),
        ('CM', 'Comida'),
        ('SN', 'Sonido'),
        ('MI', 'Miscelaneo')
    )
    id = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=50)
    descripcion = models.TextField()
    categoria = models.CharField(max_length=2, choices=CATEGORIAS)
    rating = models.DecimalField()


class Paquetes(models.Model):
    id = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=50)
    productos = models.ManyToManyField(Productos)


class Pedidos(models.Model):
    id = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=50)
    direccion = models.TextField()
    fecha_solicitado = models.DateField(auto_now_add=True)
    hora_entregado = models.DateTimeField(blank=True)
    paquetes = models.ManyToManyField(Paquetes)
    productos = models.ManyToManyField(Productos)



