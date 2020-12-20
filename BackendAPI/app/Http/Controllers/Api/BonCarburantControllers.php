<?php

namespace App\Http\Controllers\Api;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\BonCarburant;

class BonCarburantControllers extends Controller
{
    public function index(){
        $data['Bons Carburants']=BonCarburant::all();
        return response()->json($data);
    }


    public function storeBon(Request $request)
    {
        $request->validate([
            'CodeBon' => 'required|unique',
            'Montant'=> 'required']);
        $insert['CodeBon'] = $request->get('CodeBon');
        $insert['Montant'] = $request->get('Montant');
        BonCarburant::insert($request->all());
        return response()->json($request);
    }

    public function update(){

    }
    
    public function getBon($CodeBon){
        $where=array('CodeBon'=>$CodeBon);
        $data=BonCarburant::where($where)->first();
        return response()->json($data);
    }

    public function delete($CodeBon)
    {
        $where=array('CodeBon'=>$CodeBon);
        $driver=BonCarburant::where($where)->first();
        $driver->delete();
        return 204;
    }
}
