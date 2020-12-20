<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Trajets extends Model
{
    protected $fillable = [
        'idDriver',
        'Depart',
        'Destination',
        'DateDepart',
        'HeureDepart',
        'DateDestination',
        'HeureDestination',
        'Distance'
    ];
}
