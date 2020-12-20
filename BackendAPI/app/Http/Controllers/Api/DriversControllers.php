<?php

namespace App\Http\Controllers\Api;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Drivers;
use Redirect;
use PDF;
class DriversControllers extends Controller
{
    public function index(){
        $data['drivers']=Drivers::all();
        return response()->json($data);
    }


    public function storeDriver(Request $request)
    {
        $request->validate([
        'Nom' => 'required',
        'Prenom'=> 'required',
        'DateNaiss'=>  'required',
        'DatePrendreVoiture'=>  'required',
        'DateRemettreVoiture'=>  'required',
        'photoDriver'=> 'required|image|mimes:jpeg,png,jpg,gif,svg|max:2048',
        'photoPermis'=> 'required|image|mimes:jpeg,png,jpg,gif,svg|max:2048',
        'NumTel'=> 'required',
        'NumSeriePermis'=> 'required',
        'nbBonsConsomme'=> 'required',
        'nbBonsTotal'=> 'required',
        'Email'=>'required',
        'Password'=>'required'
        ]);
        if ($files = $request->file('photoDriver')) {
        $destinationPath = 'public/image/'; // upload path
        $profileImage = date('YmdHis') . "." . $files->getClientOriginalExtension();
        $files->move($destinationPath, $profileImage);
        $insert['photoDriver'] = "$profileImage";
        }
        if ($files = $request->file('photoPermis')) {
            $destinationPath = 'public/image/'; // upload path
            $permisPic = date('YmdHis') . "." . $files->getClientOriginalExtension();
            $files->move($destinationPath, $permisPic);
            $insert['photoPermis'] = "$permisPic";
            }
        $insert['Nom'] = $request->get('Nom');
        $insert['Prenom'] = $request->get('Prenom');
        $insert['DateNaiss'] = $request->get('DateNaiss');
        $insert['DatePrendreVoiture'] = $request->get('DatePrendreVoiture');
        $insert['DateRemettreVoiture'] = $request->get('DateRemettreVoiture');
        $insert['NumTel'] = $request->get('NumTel');
        $insert['NumSeriePermis'] = $request->get('NumSeriePermis');
        $insert['nbBonsConsomme'] = $request->get('nbBonsConsomme');
        $insert['DateRemettreVoiture'] = $request->get('DateRemettreVoiture');
        $insert['nbBonsTotal'] = $request->get('nbBonsTotal');
        $insert['Email'] = $request->get('Email');
        $insert['Password'] = $request->get('Password');
        Drivers::insert($request->all());
       # return response()->json($request);
       return Redirect::to('drivers')
        ->with('success','Greate! Product created successfully.');
    }
    public function getDriver($Email){
        $where=array('Email'=>$Email);
        $data=Drivers::where($where)->first();
        return response()->json($data);
    }

    public function editPicDriver($Email,$pic){
        $where=array('Email'=>$Email);
        $data=Drivers::where($where)->first();
        if ($files = file($pic)) {
            $destinationPath = 'public/image/'; // upload path
            $profileImage = date('YmdHis') . "." . $files->getClientOriginalExtension();
            $files->move($destinationPath, $profileImage);
            $data['photoDriver'] = "$profileImage";
            }
        Drivers::insert($data->all());
        return Redirect::to('drivers')
             ->with('success','Greate! Product created successfully.');

    }
     public function editPicPermis($Email,$pic){
        $where=array('Email'=>$Email);
        $data=Drivers::where($where)->first();
        if ($files = file($pic)) {
            $destinationPath = 'public/image/'; // upload path
            $profileImage = date('YmdHis') . "." . $files->getClientOriginalExtension();
            $files->move($destinationPath, $profileImage);
            $data['photoDriver'] = "$profileImage";
            }
        Drivers::insert($data->all());
        return Redirect::to('drivers')
             ->with('success','Greate! Product created successfully.');

    }
    public function ForgetPassword($Password)
    {   
        $where = array('Password' => $Password);
        $data['driver_info'] = Drivers::where($where)->first();
        return view('driver.edit', $data);
    }

    #modifier un champs dans le profile
    public function updateProfile(Request $request, $Email)
    {
        $request->validate([
        'Nom' => 'required',
        'Prenom'=> 'required',
        'DateNaiss'=>  'required',
        'DatePrendreVoiture'=>  'required',
        'DateRemettreVoiture'=>  'required',
        'NumTel'=> 'required',
        'NumSeriePermis'=> 'required',
        'nbBonsConsomme'=> 'required',
        'nbBonsTotal'=> 'required',
        'Email'=>'required',
        'Password'=>'required'
        ]);
        $update = [
        'Nom'=>$request->Nom,
        'Prenom'=>$request->Prenom,
        'DateNaiss'=>$request->DateNaiss,
        'DatePrendreVoiture'=>$request->DatePrendreVoiture,
        'DateRemettreVoiture'=>$request->DateRemettreVoiture,
        'NumTel'=>$request->NumTel,
        'NumSeriePermis'=>$request->NumSeriePermis,
        'nbBonsConsomme'=>$request->nbBonsConsomme,
        'nbBonsTotal'=>$request->nbBonsTotal,
        'Email'=>$request->Email,
        'Password'=>$request->Password];
        if ($files = $request->file('photoDriver')) {
            $destinationPath = 'public/image/'; // upload path
            $profileImage = date('YmdHis') . "." . $files->getClientOriginalExtension();
            $files->move($destinationPath, $profileImage);
            $update['photoDriver'] = "$profileImage";
            }
            $update['title'] = $request->get('title');
            $update['product_code'] = $request->get('product_code');
            $update['description'] = $request->get('description');
            Drivers::where('Email',$Email)->update($update);
            return Redirect::to('drivers')
            ->with('success','Great! Product updated successfully');
    }
    public function delete($Email)
    {
        $where=array('Email'=>$Email);
        $driver=Drivers::where($where)->first();
        $driver->delete();
        return 204;
    }
}
