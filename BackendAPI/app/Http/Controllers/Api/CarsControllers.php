<?php

namespace App\Http\Controllers\Api;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Cars;
use Redirect;
use PDF;

class CarsControllers extends Controller
{
    public function index(){
        $data['cars']=Cars::all();
        return response()->json($data);
    }

    public function storeCar(Request $request)
    {
        $request->validate([
        'Modèle' => 'required',
        'Matricule'=> 'required',
        'TypeCarburant'=>  'required',
        'Odomètre'=>  'required',
        'Carburant'=>  'required',
        'photoCar'=> 'required|image|mimes:jpeg,png,jpg,gif,svg|max:2048',
        'photoTabBord'=> 'required|image|mimes:jpeg,png,jpg,gif,svg|max:2048',
        'Status'=> 'required',
        'idDriver'=> 'required',
        ]);
        if ($files = $request->file('photoCar')) {
        $destinationPath = 'public/image/'; // upload path
        $carImage = date('YmdHis') . "." . $files->getClientOriginalExtension();
        $files->move($destinationPath, $carImage);
        $insert['photoCar'] = "$carImage";
        }
        if ($files = $request->file('photoTabBord')) {
            $destinationPath = 'public/image/'; // upload path
            $photoTabBord = date('YmdHis') . "." . $files->getClientOriginalExtension();
            $files->move($destinationPath, $photoTabBord);
            $insert['photoTabBord'] = "$photoTabBord";
            }
        $insert['Modèle'] = $request->get('Modèle');
        $insert['Matricule'] = $request->get('Matricule');
        $insert['TypeCarburant'] = $request->get('TypeCarburant');
        $insert['Odomètre'] = $request->get('Odomètre');
        $insert['Carburant'] = $request->get('Carburant');
        $insert['Status'] = $request->get('Status');
        $insert['idDriver'] = $request->get('idDriver');
        Cars::insert($request->all());
        return Redirect::to('drivers')
        ->with('success','Greate! Product created successfully.');

    }

    public function affecterCar($Matricule,$idDriver){
        $request=getCar($Matricule);
        $request['idDriver']=$idDriver;
        $request->save();
        return response()->json($request);


    }

    public function update(){

    }
    public function getCar($Matricule){
        $where=array('Matricule'=>$Matricule);
        $data=Cars::where($where)->first();
        return response()->json($data);
    }


    public function delete($Matricule)
    {
        $where=array('Matricule'=>$Matricule);
        $car=Drivers::where($where)->first();
        #$driver = Drivers::findOrFail($Email);
        $car->delete();
        return 204;
    }
}
