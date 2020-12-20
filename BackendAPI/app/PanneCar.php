<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class PanneCar extends Model
{
    protected $fillable = [
        'idDriver',
        'Matricule',
        'PrixPanne',
        'RecuPanne',
        'NumMecanicien',
        'LieuMecanicien',
        'photoRecu',  
    ];
}
