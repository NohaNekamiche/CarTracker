<?php

namespace App\Http\Controllers\Api;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\PanneCar;
use Redirect;
use PDF;


class PanneCarControllers extends Controller
{
    public function index(){
        $data['Pannes']=PanneCar::all();
        return response()->json($data);
    }

    public function storePanne(Request $request)
    {
        $request->validate([
        'PrixPanne' => 'required',
        'RecuPanne'=> 'required',
        'NumMecanicien'=>  'required',
        'LieuMecanicien'=>  'required',
        'photoRecu'=> 'required|image|mimes:jpeg,png,jpg,gif,svg|max:2048',
        'idDriver'=>  'required',
        'Matricule'=>  'required',
        ]);
        if ($files = $request->file('photoRecu')) {
        $destinationPath = 'public/image/'; // upload path
        $photoRecu= date('YmdHis') . "." . $files->getClientOriginalExtension();
        $files->move($destinationPath, $photoRecu);
        $insert['photoRecu'] = "$photoRecu";
        }
        $insert['PrixPanne'] = $request->get('PrixPanne');
        $insert['RecuPanne'] = $request->get('RecuPanne');
        $insert['NumMecanicien'] = $request->get('NumMecanicien');
        $insert['LieuMecanicien'] = $request->get('LieuMecanicien');
        $insert['idDriver'] = $request->get('idDriver');
        $insert['Matricule'] = $request->get('Matricule');
        PanneCar::insert($request->all());
        #return response()->json($request);
        return Redirect::to('panne_cars')
        ->with('success','Greate! Product created successfully.');
    }

    public function update(){

    }

    public function getPanne($Matricule){
        $where=array('Matricule'=>$Matricule);
        $data=PanneCar::where($where)->first();
        return response()->json($data);
    }
    public function delete($Matricule)
    {
        $where=array('Matricule'=>$Matricule);
        $panne=PanneCar::where($where)->first();
        $panne->delete();
        return 204;
    }
    
}
