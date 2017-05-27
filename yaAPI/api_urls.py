from django.conf.urls import url, include
from rest_framework_swagger.views import get_swagger_view

schema_view= get_swagger_view(title='Documentacion de yaAPI')
urlpatterns = [
    url(r'^eventos/', include('modules.eventos.urls')),
    url(r'^productos/', include('modules.productos.urls')),
    url(r'^yaDocs/', schema_view),
]