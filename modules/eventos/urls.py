from django.conf.urls import url
<<<<<<< HEAD
from .views import ListEventos, ListInvitados, ListEncuestas, UploadFiles, ListUsers
=======
from .views import ListEventos, ListInvitados, ListEncuestas, UploadFiles
>>>>>>> 69d6b8d24a346ea90951b1e3b2f984730b429054

urlpatterns = [
    url(r'^$', ListEventos.as_view(), name='list-eventos'),
    url(r'^invitados/$', ListInvitados.as_view(), name='list-invitados'),
    url(r'^encuestas/$', ListEncuestas.as_view(), name='list-encuesta'),
<<<<<<< HEAD
    url(r'^users/$', ListUsers.as_view(), name='list-users'),
    url(r'^invitados/files/$', UploadFiles.as_view(), name='list-invitados'),
=======
>>>>>>> 69d6b8d24a346ea90951b1e3b2f984730b429054
    url(r'^files/$', UploadFiles.as_view()),
]
# DUDA: ¿cómo subir imagenes y como saber a que imagen me refiero (invitado o evento)?
