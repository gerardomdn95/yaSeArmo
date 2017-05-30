from django.conf.urls import url
from .views import ListEventos, ListInvitados, ListEncuestas, UploadFiles, ListUsers

urlpatterns = [
    url(r'^$', ListEventos.as_view(), name='list-eventos'),
    url(r'^invitados/$', ListInvitados.as_view(), name='list-invitados'),
    url(r'^encuestas/$', ListEncuestas.as_view(), name='list-encuesta'),
    url(r'^users/$', ListUsers.as_view(), name='list-users'),
    url(r'^invitados/files/$', UploadFiles.as_view(), name='list-invitados'),
    url(r'^files/$', UploadFiles.as_view()),
]
# DUDA: ¿cómo subir imagenes y como saber a que imagen me refiero (invitado o evento)?