<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateTrajetsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('trajets', function (Blueprint $table) {
            $table->BigIncrements('id');
            $table->string('Depart');
            $table->string('Destination');
            $table->string('DateDepart');
            $table->string('HeureDepart');
            $table->string('DateDestination');
            $table->string('HeureDestination');
            $table->float('Distance');
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
        
		Schema::dropIfExists('trajets');
    }
}
