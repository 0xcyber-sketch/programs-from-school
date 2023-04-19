import { useEffect, useState } from "react"

function ChildFunction(props) {
    const [count, setCount] = useState(0)
    useEffect(() => {
        console.log(`CHILD: USEEFFECT you might perform sideeffects here`)
        //setCount((prevCount) => prevCount + props.step)
        return () => {
            console.log(`CHILD: CLEANUP EFFECT`)

        }
    }, [count])// no update test and recurvive test

    const handleCount = () => {
        setCount((prevCount) => prevCount + props.step)
    }

    return (
        <>
            <button onClick={handleCount}>Count</button>
            <h2>{`The Step received as props from parent: ${props.step} The State count: ${count}`}</h2>
        </>
    )

}
export default ChildFunction