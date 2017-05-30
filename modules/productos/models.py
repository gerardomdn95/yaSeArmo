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
    imagen = models.URLField(blank=True, null=True)
    descripcion = models.TextField()
    categoria = models.CharField(max_length=2, choices=CATEGORIAS)
    rating = models.DecimalField(max_digits=3, decimal_places=2)

    def __str__(self):
        return "%s" % self.nombre


class Paquetes(models.Model):
    id = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=50)
    imagen = models.URLField(blank=True, null=True)
    productos = models.ManyToManyField(Productos)

    def __str__(self):
        return "%s" % self.nombre


class Pedidos(models.Model):
    id = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=50)
    direccion = models.TextField()
    fecha_solicitado = models.DateField(auto_now_add=True)
    hora_entregado = models.DateTimeField(blank=True, null=True)
    paquetes = models.ManyToManyField(Paquetes)
    productos = models.ManyToManyField(Productos)

    def __str__(self):
        return "Pedido N° %s" % self.nombre

