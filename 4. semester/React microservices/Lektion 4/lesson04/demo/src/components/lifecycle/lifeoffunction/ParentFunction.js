import {useEffect, useState} from "react"

import ChildFunction from "./ChildFunction"

function ParentFunction(props) {

    const [step, setStep] = useState(2)

    useEffect(() => {
        console.log(`PARENT: USEEFFECT you might perform sideeffects here`)
        return () => {
            console.log(`PARENT: CLEANUP EFFECT`)
        }
    }, [])

    const handleStep = (event) => {

        setStep((prevStep) => prevStep + 10)
    }


    const handleUnmount = (event) => {
        console.log(`PARENT: UNMOUNTING CHILD and setting step to 100`)
        setStep(100)
    }

    if (step >= 100) {
        return (
            <h1>{`Parent rendered props:${props.initialData} state:${step}`}</h1>
        )
    }


    return (
        <>
            <button onClick={handleStep}>CHANGE STEP</button>
            <button onClick={handleUnmount}>UNMOUNT CHILD</button>
            <h1>{`Parent rendered props:${props.initialData} step:${step} `}</h1>
            <ChildFunction step={step}/>

        </>
    )

}

export default ParentFunction