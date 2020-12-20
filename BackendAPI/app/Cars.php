<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Cars extends Model
{
    protected $fillable = [
           'Modèle','Matricule',
           'TypeCarburant','Odomètre',
           'Carburant','photoCar',
           'photoTabBord','Status',
           'idDriver'
        ];
}
