<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateDriversTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('drivers', function (Blueprint $table) {
            $table->BigIncrements('id');
            $table->string('Nom');
            $table->string('Prenom');
            $table->string('Email');
            $table->string('Password');
            $table->string('DateNaiss');
            $table->string('DatePrendreVoiture');
            $table->string('DateRemettreVoiture');
            $table->text('photoDriver');
            $table->text('photoPermis');
            $table->BigInteger('NumTel');
            $table->BigInteger('NumSeriePermis');
            $table->integer('nbBonsConsomme');
            $table->integer('nbBonsTotal');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('drivers');
    }
}
