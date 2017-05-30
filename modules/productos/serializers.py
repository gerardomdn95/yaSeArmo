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
<<<<<<< HEAD
        fields = ('id', 'nombre', 'imagen', 'productos')
=======
        fields = ('id', 'nombre', 'imagen', 'productos')  # ERROR: Despliega solo un producto
>>>>>>> 69d6b8d24a346ea90951b1e3b2f984730b429054


class PedidosSerializer(serializers.ModelSerializer):
    paquetes = PaquetesSerializer(many=True, read_only=True)
    productos = ProductosSerializer(many=True, read_only=True)

    class Meta:
        model = Pedidos
        fields = ('id', 'nombre', 'direccion', 'fecha_solicitado', 'hora_entregado', 'paquetes', 'productos')

