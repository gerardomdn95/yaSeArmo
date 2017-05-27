from django.contrib import admin
from .models import Evento, Invitado


class EventoAdmin(admin.ModelAdmin):
    pass


class InvitadoAdmin(admin.ModelAdmin):
    pass

admin.site.register(Evento, EventoAdmin)
admin.site.register(Invitado, InvitadoAdmin)

