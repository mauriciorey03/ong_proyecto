# Lista de nombres
nombres = [
    "Campus",
    "City",
    "MaterialAid",
    "Occupation",
    "Partner",
    "Product",
    "QuotaType",
    "RequerimentH",
    "Shelter",
    "Shipping",
    "Users",
    "Volunteer",
    "VolunteerH"
]  


# Plantilla del archivo
plantilla = """
package com.ong.campus.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.*;
import com.ong.campus.repositories.entities.*;
import com.ong.campus.services.*;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class Service{nombre}Impl implements Service{nombre} {{

    private {nombre}Repository {nombre2}Repository;

    @Override
    @Transactional(readOnly = true)
    public List<{nombre}> findAll() {{
        return (List<{nombre}>) {nombre2}Repository.findAll();
    }}

    @Override
    public {nombre} save({nombre} {nombre2}) {{
        return {nombre2}Repository.save({nombre2});
    }}

    @Override
    public {nombre} update(Long id, {nombre} {nombre2}) {{
        Optional<{nombre}> {nombre2}CurrentOptional = {nombre2}Repository.findById(id);

        if({nombre2}CurrentOptional.isPresent()) {{
            {nombre} {nombre2}Current = {nombre2}CurrentOptional.get();
            {nombre2}Current.setName({nombre2}.getName());
            {nombre2}Repository.save({nombre2}Current);
            return {nombre2}Current;
        }}

        return null;
    }}

    @Override
    public void delete(Long id) {{
        Optional<{nombre}> {nombre2}Optional={nombre2}Repository.findById(id);
        if({nombre2}Optional.isPresent()) {{
            {nombre2}Repository.delete({nombre2}Optional.get());
        }}   
    }}

    @Override
    public {nombre} findById(Long id) throws BussinesRuleException {{
        Optional<{nombre}> {nombre2}Optional = {nombre2}Repository.findById(id);
        if(!{nombre2}Optional.isPresent()) {{
            BussinesRuleException exception= new BussinesRuleException("1001","Error! {nombre} doesn't exist",HttpStatus.PRECONDITION_FAILED);
            throw exception; 
        }}
        return {nombre2}Optional.get();
    }}

}}
"""

# Iterar sobre cada nombre
for nombre in nombres:
    # Generar el contenido del archivo reemplazando {nombre} y {nombre2} en la plantilla con los nombres actuales
    contenido = plantilla.format(nombre=nombre, nombre2=nombre.lower())
    
    # Escribir el contenido en un archivo con el nombre adecuado
    nombre_archivo = f"Service{nombre}Impl.java"
    with open(nombre_archivo, "w") as archivo:
        archivo.write(contenido)

    print(f"Archivo {nombre_archivo} creado exitosamente.")