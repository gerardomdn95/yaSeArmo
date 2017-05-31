from django.conf.urls import url
from .views import ListPaquetes, ListPedidos, ListProductos, DetailProductos, DetailPaquetes, DetailPedidos, UploadFiles


urlpatterns = [
    url(r'^$', ListProductos.as_view(), name="list-productos"),
    url(r'^(?P<pk>[0-9]+)/$', DetailProductos.as_view()),
    url(r'^files/$', UploadFiles.as_view()),
    url(r'^paquetes/$', ListPaquetes.as_view(), name="list-paquetes"),
    url(r'^paquetes/(?P<pk>[0-9]+)/$', DetailPaquetes.as_view()),
    url(r'^paquetes/files/$', UploadFiles.as_view()),
    url(r'^pedidos/$', ListPedidos.as_view(), name="list-pedidos"),
    url(r'^pedidos/(?P<pk>[0-9]+)/$', DetailPedidos.as_view()),
]