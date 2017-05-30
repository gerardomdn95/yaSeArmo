from rest_framework import serializers
from .models import Productos, Paquetes, Pedidos


class ProductosSerializer(serializers.ModelSerializer):
    class Meta:
        model = Productos
        fields = '__all__'


class PaquetesSerializer(serializers.ModelSerializer):
    productos = ProductosSerializer(many=True, read_only=True)

    class Meta:
        model = Paquetes
        fields = ('id', 'nombre', 'imagen', 'productos')


class PedidosSerializer(serializers.ModelSerializer):
    paquetes = PaquetesSerializer(many=True, read_only=True)
    productos = ProductosSerializer(many=True, read_only=True)

    class Meta:
        model = Pedidos
        fields = ('id', 'nombre', 'direccion', 'fecha_solicitado', 'hora_entregado', 'paquetes', 'productos')

