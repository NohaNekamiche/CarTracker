<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateCarsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('cars', function (Blueprint $table) {
            $table->BigIncrements('id');
            $table->string('Modèle');
            $table->BigInteger('Matricule');
            $table->string('TypeCarburant');
            $table->float('Odomètre');
            $table->float('Carburant');
            $table->text('photoCar');
            $table->text('photoTabBord');
            $table->string('Status');
            $table->BigInteger('idDriver');
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
        
		Schema::dropIfExists('cars');
    }
}
