# -*- coding: utf-8 -*-
# Generated by Django 1.10.7 on 2017-05-29 05:03
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('eventos', '0003_auto_20170529_0503'),
    ]

    operations = [
        migrations.AlterField(
            model_name='evento',
            name='invitados',
            field=models.ManyToManyField(blank=True, to='eventos.Invitado'),
        ),
    ]
