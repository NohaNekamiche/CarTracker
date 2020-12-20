<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::post('registrer','Api\Auth\RegisterController@register');

#Route::middleware('auth:api')->get('/user', function (Request $request) {
#   return $request->user();
#});
Route::group([
    'prefix' => 'auth'
], function () {
    Route::post('login', 'AuthController@login');
    Route::post('signup', 'AuthController@signup');
  
    Route::group([
      'middleware' => 'auth:api'
    ], function() {
        Route::get('logout', 'AuthController@logout');
        Route::get('user', 'AuthController@user');
    });
});


#Post requests
Route::post('/addTrajet','Api\TrajetsControllers@storeTrajet');
Route::post('/addDriver','Api\DriversControllers@storeDriver');
Route::post('/addCar','Api\CarsControllers@storeCar');
Route::post('/addPanne','Api\PanneCarControllers@storePanne');
Route::post('/addBonCarburant','Api\BonCarburantControllers@storeBon');
Route::post('/addTrajet','Api\TrajetsControllers@storeTrajet');



#get requests

Route::get('Listdrivers','Api\DriversControllers@index');
Route::get('driver/{Email}','Api\DriversControllers@getDriver');
Route::get('ListCars','Api\CarsControllers@index');
Route::get('car/{Matricule}','Api\CarsControllers@getCar');
Route::get('ListBon','Api\BonCarburantControllers@index');
Route::get('bon/{CodeBon}','Api\BonCarburantControllers@getBon');
Route::get('AfficherTrajets','Api\TrajetsControllers@index');
Route::get('trajet/{idDriver}','Api\TrajetsControllers@getTrajet');
Route::get('ListPannes','Api\PanneCarControllers@index');
Route::get('Panne/{Matricule}','Api\PanneCarControllers@getPanne');

#delete requests

Route::delete('deleteDriver/{Email}','Api\DriversControllers@delete');
Route::delete('deleteCar/{Matricule}','Api\CarsControllers@delete');
Route::delete('deleteBon/{CodeBon}','Api\BonCarburantControllers@delete');
Route::delete('deleteTrajet/{idDriver}','Api\TrajetsControllers@delete');
Route::delete('deletePanne/{Matricule}','Api\PanneCarControllers@delete');
