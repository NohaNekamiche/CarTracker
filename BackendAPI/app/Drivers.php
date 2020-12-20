<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Drivers extends Model
{
    protected $fillable = [
        'Nom','Prenom','DateNaiss',
        'DatePrendreVoiture','DateRemettreVoiture'
        ,'photoDriver','photoPermis','NumTel',
        'NumSeriePermis','nbBonsConsomme','nbBonsTotal',
        'Email','Password'
    ];
}
