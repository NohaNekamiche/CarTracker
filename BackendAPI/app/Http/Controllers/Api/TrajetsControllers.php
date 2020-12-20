<?php

namespace App\Http\Controllers\Api;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Trajets;
class TrajetsControllers extends Controller
{
    public function index(){
        $data['Trajets']=Trajets::all();
        return response()->json($data);
    }

    public function storeTrajet(Request $request)
    {
        $request->validate([
            'Depart' => 'required',
            'Destination' => 'required',
            'DateDepart' =>  'required',
            'HeureDepart' =>  'required',
            'DateDestination' => 'required',
            'HeureDestination' =>  'required',
            'Distance' =>  'required',
            'idDriver' =>  'required'
        ]);
        $insert['Depart'] = $request->get('Depart');
        $insert['Destination'] = $request->get('Destination');
        $insert['DateDepart'] = $request->get('DateDepart');
        $insert['HeureDepart'] = $request->get('HeureDepart');
        $insert['DateDestination'] = $request->get('DateDestination');
        $insert['HeureDestination'] = $request->get('HeureDestination');
        $insert['idDriver'] = $request->get('idDriver');
        $insert['Distance'] = $request->get('Distance');
        
        Trajets::insert($request->all());
        return response()->json($request);
    }

    public function store(Request $request){
        $trajet=Trajets::all();
        $trajet=new Trajets();
        $trajet->Depart=$request->Depart;
        $trajet->Destination=$request->Destination;
        $trajet->DateDepart=$request->DateDepart;
        $trajet->HeureDepart=$request->HeureDepart;
        $trajet->DateDestination=$request->DateDestination;
        $trajet->HeureDestination=$request->HeureDestination;
        $trajet->idDriver=$request->idDriver;
        $trajet->Distance=$request->Distance;
        $trajet->save();
        return response()->json($trajet);

    }
    public function showTrajets(){
        $trajet=Trajets::All();
        return response()->json($trajet);
    }
    public function getTrajet($idDriver){
        $where=array('idDriver'=>$idDriver);
        $data=Trajets::where($where)->first();
        return response()->json($data);
    }
    public function delete($idDriver)
    {
        $where=array('idDriver'=>$idDriver);
        $driver=Trajets::where($where)->first();
        $driver->delete();
        return 204;
    }
}
