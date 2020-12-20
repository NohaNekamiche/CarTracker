<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreatePanneCarsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('panne_cars', function (Blueprint $table) {
            $table->BigIncrements('id');
            $table->BigInteger('PrixPanne');
            $table->BigInteger('RecuPanne');
            $table->BigInteger('NumMecanicien');
            $table->string('LieuMecanicien');
            $table->text('photoRecu');
            $table->BigInteger('idDriver');
            $table->BigInteger('Matricule');
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
        Schema::dropIfExists('panne_cars');
    }
}
