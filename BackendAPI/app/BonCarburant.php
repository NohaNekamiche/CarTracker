<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class BonCarburant extends Model
{
     protected $fillable = [
        'id',
        'CodeBon',
        'Montant',
     ];
}
